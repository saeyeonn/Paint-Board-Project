package text;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

// 텍스트 설정 값 저장
class TextMaps {
    public static Map<JTextField, TextBoxInfo> infoMap = new HashMap<>();
    public static Map<JTextField, States> statesMap = new HashMap<>();
}
