package Examples.Classes.WithSimpleArrays;

import Examples.Classes.Simple.MixedAll;
import Examples.Enums.Color;
import Examples.Enums.Language;

import java.util.Arrays;

public class MatrixObject {
    private MixedAll[][] mixedMatr;

    public MatrixObject() {
        this.mixedMatr = new MixedAll[2][];
        MixedAll[] arr1 = new MixedAll[1];
        MixedAll[] arr2 = new MixedAll[1];
        arr1[0] = new MixedAll("a", Color.RED, 1, Language.EN, "b", 2);
        this.mixedMatr[0] = arr1;
        this.mixedMatr[1] = arr2;
    }

    public MatrixObject(int size1, int size2) {
        mixedMatr = new MixedAll[size1][size2];
    }

    public MatrixObject(MixedAll[][] mixedMatr) {
        this.mixedMatr = mixedMatr;
    }

    public MixedAll[][] getMixedMatr() {
        return mixedMatr;
    }

    public void setMixedMatr(MixedAll[][] mixedMatr) {
        this.mixedMatr = mixedMatr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixObject that = (MatrixObject) o;
        if (mixedMatr.length != that.mixedMatr.length) {
            return false;
        }

        for (int i = 0; i < mixedMatr.length; ++i) {
            if (!Arrays.equals(mixedMatr[i], that.mixedMatr[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(mixedMatr);
    }
}
