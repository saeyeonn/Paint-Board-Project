package text;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class BoldUnderline {
    private static JTextField selectedTextField = null; // 현재 선택된 TB 저장
    private static Map<JTextField, TextState> statesMap = TextMaps.statesMap;
    // private static Map<JTextField, TextStates> checkBoxStatesMap = new HashMap<>(); // 각 TB의 체크 표시 설정 저장

    private static TextCheckBoxForm boldBox;
    private static TextCheckBoxForm underlineBox;

    public BoldUnderline(TextCheckBoxForm boldBox, TextCheckBoxForm underlineBox) {
        BoldUnderline.boldBox = boldBox;
        BoldUnderline.underlineBox = underlineBox;
    }

    // 체크 박스에 이벤트 발생시 상태 저장 & 적용
    public void checkBoxSetting() {
        if (selectedTextField != null) {
            storeCheckBoxStates(selectedTextField); // 체크 박스 상태 저장
            applySelectedAttributes(); // 현재 선택 된 TB에 서식 적용
        }
    }

    // TB 설정 가져와서 맞게 설정
    static void textCilcked(JTextField textField) {
        if (textField != null) {
            selectedTextField = textField; // 현재 클릭한 것 선택된 걸로 설정

            loadCheckBoxStates(); // 현재 클릭한 것의 ChechBoxStates 가져와서 체크박스 상태 로드
            applySelectedAttributes(); // 가져온 체크 박스 설정을 바탕으로 폰트 스타일 조절

            // 각 TB에 대한 체크 박스 설정 객체를 생성하여 맵에 추가
            if (!statesMap.containsKey(textField)) {
                statesMap.put(textField, new TextState());
            }
        } else {
            boldBox.setSelected(false);
            underlineBox.setSelected(false);
        }
    }

    // 현재 선택된 TB에 서식 적용
    private static void applySelectedAttributes() {
        // 선택된 TB가 있는 경우에만 작업 실행
        if (selectedTextField != null) {
            TextState checkBoxStates = statesMap.get(selectedTextField);

            if (checkBoxStates != null) { // null 체크 추가
                Font font = selectedTextField.getFont();
                int style = Font.PLAIN;

                if (checkBoxStates.isBold()) {
                    style |= Font.BOLD;
                }

                Font newFont = font.deriveFont(style);
                selectedTextField.setFont(newFont);

                Map<TextAttribute, Object> attributes = new HashMap<>();

                if (checkBoxStates.isUnderline()) {
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                } else {
                    attributes.put(TextAttribute.UNDERLINE, -1); // 밑줄 제거
                }

                newFont = newFont.deriveFont(attributes);
                selectedTextField.setFont(newFont);
            }
        }
    }

    // 체크 박스 설정 저장
    private static void storeCheckBoxStates(JTextField textField) {
        if (textField != null && boldBox != null && underlineBox != null) {
            TextState checkBoxStates = statesMap.get(textField);
            if (checkBoxStates == null) {
                checkBoxStates = new TextState();
                statesMap.put(textField, checkBoxStates);
            }
            checkBoxStates.setBold(boldBox.isSelected());
            checkBoxStates.setUnderline(underlineBox.isSelected());
        }
    }

    // 체크 박스 설정 로드하여 선택 상태 업데이트
    private static void loadCheckBoxStates() {
        if (selectedTextField != null) {
            TextState checkBoxStates = statesMap.get(selectedTextField);
            if (checkBoxStates != null) { // null 체크 추가
                boldBox.setSelected(checkBoxStates.isBold());
                underlineBox.setSelected(checkBoxStates.isUnderline());
            }
        }
    }
}