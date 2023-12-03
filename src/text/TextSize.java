package text;

import javax.swing.*;

import window.TextSpinnerForm;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TextSize {
    private static JTextField selectedTextField = null; // 현재 선택된 TB 저장
    private static Map<JTextField, TextBoxInfo> infoMap = TextMaps.infoMap;
    private static Map<JTextField, States> statesMap = TextMaps.statesMap;
    // private static Map<JTextField, TextStates> SizeStatesMap = new HashMap<>(); // 각 TB의 체크 표시 설정 저장

    private static TextSpinnerForm fontSizeSpinner;

    public TextSize(TextSpinnerForm fontSizeSpinner) {
        TextSize.fontSizeSpinner = fontSizeSpinner;
    }

    // 크기 선택 시 상태 저장 & 적용
    public static void fontSizeSetting() {
        if (selectedTextField != null) {
            storeFontSize(selectedTextField); // 상태 저장
            applySelectedAttributes(); // 현재 선택 된 TB에 서식 적용
        }
    }

    static void textCilcked(JTextField textField) {
        selectedTextField = textField; // 현재 클릭한 것 선택된 걸로 설정

        loadFontSize(); // 현재 클릭한 것의 TextStates 가져와서 체크박스 상태 로드
        applySelectedAttributes(); // 가져온 체크 박스 설정을 바탕으로 폰트 스타일 조절

        // 각 TB에 대한 체크 박스 설정 객체를 생성하여 맵에 추가
        if (!statesMap.containsKey(textField)) {
            statesMap.put(textField, new States());
        }
    }

    // 현재 선택된 TB에 크기 적용
    public static void applySelectedAttributes() {
        // 선택된 TB가 있는 경우에만 작업 실행
        if (selectedTextField != null) {
            States SizeStates = statesMap.get(selectedTextField);

            if (SizeStates != null) { // null 체크 추가
                Font font = selectedTextField.getFont();
                int size = 1;

                if (SizeStates.getFontSize() >= 0) {
                    size = (int) TextSpinnerForm.getFontSizeSpinner().getValue(); // 선택한 크기 가져오기
                }

                System.out.println("사이즈"+ (int) TextSpinnerForm.getFontSizeSpinner().getValue());

                Font newFont = new Font(font.getName(), font.getStyle(), size);
                selectedTextField.setFont(newFont);  // 그 폰트 객체에 맞게 새로운 크기 적용

                // 텍스트 필드의 크기 업데이트 (텍스트 크기에 비례하여)
                updateTextFieldSize(selectedTextField);
            }
        }
    }

    private static void updateTextFieldSize(JTextField textField) {
        FontMetrics metrics = textField.getFontMetrics(textField.getFont()); // 특정 글꼴에 대한 측정치 제공
        int textWidth = metrics.stringWidth(textField.getText()); // 텍스트의 폭 측정
        int textHeight = metrics.getHeight(); // 텍스트의 높이 측정

        // 텍스트 크기에 비례하여 텍스트 필드 크기 업데이트
        textField.setSize(textWidth + 15, textHeight + 15);

        Container container = textField.getParent();
        if (container != null) {
            container.repaint();
            container.revalidate();
        }

        infoMap.get(textField).wAndh(textWidth, textHeight);
    }

    // 현재 설정 저장
    private static void storeFontSize(JTextField textField) {
        if (textField != null && fontSizeSpinner != null) {
            States SizeStates = statesMap.get(textField);
            if (SizeStates == null) {
                SizeStates = new States();
                statesMap.put(textField, SizeStates);
            }
            int currentSize = (int) fontSizeSpinner.getValue();
            SizeStates.setFontSize(currentSize);
        }
    }

    // 폰트 크기 로드하여 선택 상태 업데이트
    private static void loadFontSize() {
        if (selectedTextField != null && fontSizeSpinner != null) {
            States SizeStates = statesMap.get(selectedTextField);
            if (SizeStates != null) { // null 체크 추가
                if (SizeStates.getFontSize() > 0) {
                    fontSizeSpinner.setValue(SizeStates.getFontSize());
                }
            }
        }   

    }  
}