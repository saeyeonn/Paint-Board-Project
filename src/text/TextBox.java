package text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import window.TextComboBoxForm;
import window.TextSpinnerForm;

public class TextBox {
    private static JPanel panel;
    private static List<JTextField> textBoxList = new ArrayList<>();
    private static Map<JTextField, TextBoxInfo> infoMap = TextMaps.infoMap;
    private static Map<JTextField, States> statesMap = TextMaps.statesMap;

    private static JTextField selectedTextBox = null; // 현재 선택된 TextBox 저장
    private static boolean isTextBoxCreating = false; // 새로운 TB를 생성 중인지 여부를 나타내는 변수
    private static final int BORDER_SIZE = 3; // 선택된 TB의 테두리 크기
    private static final Border defaultBorder = UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border");
        // TB의 기본 테두리 스타일 (선택 해제할 때 기존 테두리 원상 복귀하기 위해 사용)

    public TextBox(JPanel panel) {
        TextBox.panel = panel;
    }

    public TextBox() {
    }

    // 텍스트 버튼 누르면 TB 생성 가능 상태가 됨
    public void setCreating() {
        isTextBoxCreating = true;
        System.out.println("눌림!");
    }

    public void click(MouseEvent e){
        // TB 생성 가능 상태 일 때 (버튼을 눌렀을 때) TB 생성
        if (isTextBoxCreating) { 
            JTextField newTextBox = createTextBox(e.getX(), e.getY(), "New Text Box");
            textBoxList.add(newTextBox);
            addTextBoxListener(newTextBox); // 마우스 클릭 이벤트 리스너 등록
            panel.add(newTextBox); // 패널에 TB 추가
            
            FontType.textCilcked(newTextBox); // 폰트 타입 상태칸 만들기
            TextSize.textCilcked(newTextBox); // 텍스트 사이즈 상태칸 만들기
            BoldUnderline.textCilcked(newTextBox); // 체크 박스 상태칸 만들기

            infoMap.get(newTextBox).xAndy(e.getX(), e.getY());
            
            panel.repaint(); // 컴포넌트 추가했으므로 새로운 상태로 화면 갱신
            pickCurrent(newTextBox); // 생성된 것을 우선 선택

            isTextBoxCreating = false; // 생성 종료
            panel.requestFocusInWindow(); // 텍스트 박스가 생성되자마자 패널에 포커스를 이동

        // TB 생성 가능 상태가 아닐 때 빈 공간 선택시, 모든 TB 선택 해제
        } else {
            if (selectedTextBox != null) { // 선택 된 박스가 있다면
                setUnselectedStyle(selectedTextBox); // 선택 된 박스의 테두리를 원상 복귀
                selectedTextBox = null; // 선택 해제
                
                FontType.textCilcked(null); // 연결 해제
                TextSize.textCilcked(null); 
                BoldUnderline.detach();
                
                TextSpinnerForm.getFontSizeSpinner().setValue(12);
                TextComboBoxForm.getFontComboBox().setSelectedIndex(0);            
            }
        }
    }

    // TB 위치 올바르게 배치
    public void arrangeTextBoxes() {
        for (JTextField textBox : textBoxList) {
            TextBoxInfo textBoxInfo = infoMap.get(textBox);
            int x = textBoxInfo.getX();
            int y = textBoxInfo.getY();
            int w = textBoxInfo.getW();
            int h = textBoxInfo.getH();
            textBox.setBounds(x, y, w, h);
            TextSize.updateTextFieldSize(textBox);
            //textBox.setBounds(x, y, 100, 30);
        }

        panel.repaint();

        if (textBoxList.size() > 0) {
            panel.setLayout(null);
        }
    }

    // TB 생성
    private static JTextField createTextBox(int x, int y, String text) {
        JTextField textField = new JTextField(text);

        Font defaultFont = new Font("Arial", Font.PLAIN, 12); // 기본 폰트 및 스타일 설정
        textField.setFont(defaultFont);

        // 패널의 크기를 고려하여 위치를 조정
        int maxX = panel.getWidth() - textField.getWidth();
        int maxY = panel.getHeight() - textField.getHeight();
    
        // x와 y가 패널 경계를 넘어가지 않도록 제한
        x = Math.min(Math.max(x, 0), maxX);
        y = Math.min(Math.max(y, 0), maxY);

        infoMap.put(textField, new TextBoxInfo());
        statesMap.put(textField, new States());
        
        textField.setBounds(x, y, 0, 0); // TB 위치 및 크기 설정
        textField.requestFocusInWindow(); // 포커스 설정 추가

        return textField;
    }

     // 마우스 클릭시 수행할 동작이 정의된 이벤트 리스너를 등록
     private static void addTextBoxListener(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() { // JTextField에 마우스 이벤트 처리 인스턴스 등록
            @Override
            public void mouseClicked(MouseEvent e) { // 마우스 클릭 발생시
                pickCurrent(textField);
            }
        });
    }

    // 마우스 클릭에 대한 동작 (선택에 대한 테두리 변화)
    private static void pickCurrent(JTextField textField) {
        if (selectedTextBox != null) { // 선택 된 TB가 있다면 
            setUnselectedStyle(selectedTextBox); // 기존에 선택 되었던 박스의 테두리를 원상 복귀
            TextSize.updateTextFieldSize(selectedTextBox);
        }
        selectedTextBox = textField; // 현재 클릭된 박스를 선택 대상으로 설정
        setSelectedStyle(selectedTextBox); // 현재 클릭된 박스의 테두리 강조
        FontType.textCilcked(selectedTextBox);
        TextSize.textCilcked(selectedTextBox);
        BoldUnderline.textCilcked(selectedTextBox);
    }

    // 테두리 강조
    private static void setSelectedStyle(JTextField textField) {
        textField.setBorder(new LineBorder(Color.RED, BORDER_SIZE)); // Set a red border to indicate selection
    }

    // 테두리 원상 복귀
    private static void setUnselectedStyle(JTextField textField) {
        textField.setBorder(defaultBorder); // Restore the default border to indicate deselection
        FontType.textCilcked(null);
        TextSize.textCilcked(null);
        BoldUnderline.textCilcked(null);
    } 

    // 은아 -> develop
}
