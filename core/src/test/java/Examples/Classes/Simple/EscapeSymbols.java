package Examples.Classes.Simple;

import java.util.Objects;

public class EscapeSymbols {
    private String escapeSymbolString;
    private char escapeSymbolChar;
    private Character escapeSymbolCharacter;
    public EscapeSymbols() {
        escapeSymbolString = "\",\\/\b\f\n\r\t\u1234abc";
        escapeSymbolChar = '\"';
        escapeSymbolCharacter = '\"';
    }

    public String getEscapeSymbolString() {
        return escapeSymbolString;
    }

    public void setEscapeSymbolString(String escapeSymbolString) {
        this.escapeSymbolString = escapeSymbolString;
    }

    public char getEscapeSymbolChar() {
        return escapeSymbolChar;
    }

    public void setEscapeSymbolChar(char escapeSymbolChar) {
        this.escapeSymbolChar = escapeSymbolChar;
    }

    public Character getEscapeSymbolCharacter() {
        return escapeSymbolCharacter;
    }

    public void setEscapeSymbolCharacter(Character escapeSymbolCharacter) {
        this.escapeSymbolCharacter = escapeSymbolCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscapeSymbols that = (EscapeSymbols) o;
        return getEscapeSymbolChar() == that.getEscapeSymbolChar()
                && escapeSymbolString.equals(that.escapeSymbolString)
                && escapeSymbolCharacter.equals(that.escapeSymbolChar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEscapeSymbolString(), getEscapeSymbolChar(), getEscapeSymbolCharacter());
    }
}
