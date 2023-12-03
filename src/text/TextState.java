package text;
public class TextState {
    private boolean bold = false; // bold 상태 나타냄
    private boolean underline = false; // underline 상태 나타냄
    private String fontName = "Arial"; // 폰트 이름
    private int fontSize = 12; // 텍스트 크기

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public void setUnderline(boolean underline) {
        this.underline = underline;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isBold() { // bold 선택 여부 반환
        return bold;
    }

    public boolean isUnderline() { // ubderline 선택 여부 반환
        return underline;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }
}
