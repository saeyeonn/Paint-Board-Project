package text;

import javax.swing.*;

import window.TextComboBoxForm;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class FontType {
    private static JTextField selectedTextField = null; // 현재 선택된 TB 저장
    private static Map<JTextField, States> statesMap = TextMaps.statesMap;
    // private static Map<JTextField, TextStates> FontStatesMap = new HashMap<>(); // 각 TB의 체크 표시 설정 저장

    private static TextComboBoxForm fontComboBoxForm;

    public FontType(TextComboBoxForm fontcomboboxform) {
        FontType.fontComboBoxForm = fontcomboboxform;
    }

    // 폰트 선택 시 상태 저장 & 적용
    public static void FontTypeSetting() {
        if (selectedTextField != null) {
            storeFontType(selectedTextField); // 체크 박스 상태 저장
            applySelectedAttributes(); // 현재 선택 된 TB에 서식 적용
        }
    }

    // TB 설정 가져와서 맞게 설정
    static void textCilcked(JTextField textField) {
        selectedTextField = textField; // 현재 클릭한 것 선택된 걸로 설정

        loadFontType(); // 현재 클릭한 것의 TextStates 가져와서 체크박스 상태 로드
        applySelectedAttributes(); // 가져온 체크 박스 설정을 바탕으로 폰트 스타일 조절

        // 각 TB에 대한 체크 박스 설정 객체를 생성하여 맵에 추가
        if (!statesMap.containsKey(textField)) {
            statesMap.put(textField, new States());
        }
    }

    // 현재 선택된 TB에 폰트 적용
    private static void applySelectedAttributes() {
        // 선택된 TB가 있는 경우에만 작업 실행
        if (selectedTextField != null) {
            States FontStates = statesMap.get(selectedTextField);
    
            if (FontStates != null) { // null 체크 추가
                Font font = selectedTextField.getFont();
                String name = "Arial";
    
                if (FontStates.getFontName() != null) {
                    name = (String) TextComboBoxForm.getFontComboBox().getSelectedItem(); // 선택한 폰트 가져오기
                }

                Map<TextAttribute, Object> attributes = new HashMap<>();
                if (FontStates.isUnderline()) {
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                }
    
                Font newFont = new Font(name, font.getStyle(), font.getSize()).deriveFont(attributes);
                selectedTextField.setFont(newFont);  // 그 폰트 객체에 맞게 새로운 글꼴 적용
            }
        }
    }

    // 현재 설정 저장
    private static void storeFontType(JTextField textField) {
        if (textField != null && fontComboBoxForm != null) {
            States FontStates = statesMap.get(textField);
            if (FontStates == null) {
                FontStates= new States();
                statesMap.put(textField, FontStates);
            }
            FontStates.setFontName((String) fontComboBoxForm.getSelectedItem());
            System.out.println("폰트 저장 완료 "+ (String) fontComboBoxForm.getSelectedItem());
        }
    }

    // 폰트 타입 로드하여 선택 상태 업데이트
    private static void loadFontType() {
        if (selectedTextField != null) {
            States FontStates = statesMap.get(selectedTextField);
            if (FontStates != null) { // null 체크 추가
                fontComboBoxForm.setSelectedItem(FontStates.getFontName());
            }
        }
    }
}

