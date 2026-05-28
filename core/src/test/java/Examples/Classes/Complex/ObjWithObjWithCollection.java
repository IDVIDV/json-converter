package Examples.Classes.Complex;

import Examples.Classes.Simple.MixedAll;
import Examples.Classes.WithCollections.CollectionObject;
import Examples.Enums.Color;
import Examples.Enums.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjWithObjWithCollection {
    private List<MixedAll> listMixed;
    private CollectionObject objField;

    public ObjWithObjWithCollection() {
        this.listMixed = new ArrayList<>();
        this.listMixed.add(new MixedAll("a", Color.RED, 1, Language.EN, "b", 2));
        this.listMixed.add(new MixedAll());
        objField = new CollectionObject();
    }

    public ObjWithObjWithCollection(List<MixedAll> listMixed, CollectionObject objField) {
        this.listMixed = listMixed;
        this.objField = objField;
    }

    public List<MixedAll> getListMixed() {
        return listMixed;
    }

    public void setListMixed(List<MixedAll> listMixed) {
        this.listMixed = listMixed;
    }

    public CollectionObject getObjField() {
        return objField;
    }

    public void setObjField(CollectionObject objField) {
        this.objField = objField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjWithObjWithCollection that = (ObjWithObjWithCollection) o;
        return Objects.equals(getListMixed(), that.getListMixed()) && Objects.equals(getObjField(), that.getObjField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListMixed(), getObjField());
    }
}
