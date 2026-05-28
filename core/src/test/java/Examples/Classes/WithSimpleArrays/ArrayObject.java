package Examples.Classes.WithSimpleArrays;

import Examples.Classes.Simple.MixedAll;
import Examples.Enums.Color;
import Examples.Enums.Language;

import java.util.Arrays;

public class ArrayObject {
    private MixedAll[] mixedArr;

    public ArrayObject() {
        this.mixedArr = new MixedAll[3];
        this.mixedArr[0] = null;
        this.mixedArr[1] = new MixedAll();
        this.mixedArr[2] = new MixedAll("a", Color.RED, 1, Language.EN, "b", 2);
    }

    public ArrayObject(int arrSize) {
        this.mixedArr = new MixedAll[arrSize];
    }

    public ArrayObject(MixedAll[] mixedArr) {
        this.mixedArr = mixedArr;
    }

    public MixedAll[] getMixedArr() {
        return mixedArr;
    }

    public void setMixedArr(MixedAll[] mixedArr) {
        this.mixedArr = mixedArr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayObject that = (ArrayObject) o;
        return Arrays.equals(getMixedArr(), that.getMixedArr());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getMixedArr());
    }
}
