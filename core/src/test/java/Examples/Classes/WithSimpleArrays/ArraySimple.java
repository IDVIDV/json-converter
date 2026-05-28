package Examples.Classes.WithSimpleArrays;

import Examples.Enums.Language;
import java.util.Arrays;

public class ArraySimple {
    private int[] intArr;
    private Integer[] integerArr;
    private String[] stringArr;
    private Language[] languageArr;

    public ArraySimple() {
        this.intArr = new int[3];
        this.intArr[0] = 1;
        this.intArr[1] = 2;
        this.intArr[2] = 3;

        this.integerArr = new Integer[3];
        this.integerArr[0] = 9;
        this.integerArr[1] = 8;
        this.integerArr[2] = 7;

        this.stringArr = new String[2];
        this.stringArr[0] = "abc";
        this.stringArr[1] = "def";

        this.languageArr = new Language[1];
        this.languageArr[0] = Language.EN;
    }

    public ArraySimple(int arrSize) {
        this.intArr = new int[arrSize];
        this.integerArr = new Integer[arrSize];
        this.stringArr = new String[arrSize];
        this.languageArr = new Language[arrSize];
    }

    public ArraySimple(int[] intArr, Integer[] integerArr, String[] stringArr, Language[] languageArr) {
        this.intArr = intArr;
        this.integerArr = integerArr;
        this.stringArr = stringArr;
        this.languageArr = languageArr;
    }

    public int[] getIntArr() {
        return intArr;
    }

    public void setIntArr(int[] intArr) {
        this.intArr = intArr;
    }

    public Integer[] getIntegerArr() {
        return integerArr;
    }

    public void setIntegerArr(Integer[] integerArr) {
        this.integerArr = integerArr;
    }

    public String[] getStringArr() {
        return stringArr;
    }

    public void setStringArr(String[] stringArr) {
        this.stringArr = stringArr;
    }

    public Language[] getLanguageArr() {
        return languageArr;
    }

    public void setLanguageArr(Language[] languageArr) {
        this.languageArr = languageArr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArraySimple that = (ArraySimple) o;
        return Arrays.equals(intArr, that.intArr)
                && Arrays.equals(integerArr, that.integerArr)
                && Arrays.equals(stringArr, that.stringArr)
                && Arrays.equals(languageArr, that.languageArr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(intArr);
        result = 31 * result + Arrays.hashCode(integerArr);
        result = 31 * result + Arrays.hashCode(stringArr);
        result = 31 * result + Arrays.hashCode(languageArr);
        return result;
    }
}
