package Examples.Classes.WithCollections;

import Examples.Classes.Simple.MixedAll;
import Examples.Enums.Color;
import Examples.Enums.Language;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class CollectionNotInterface {
    private ArrayList<MixedAll> arrList;
    private LinkedList<MixedAll> linkList;

    public CollectionNotInterface() {
        this.arrList = new ArrayList<>();
        this.arrList.add(new MixedAll("a", Color.RED, 1, Language.EN, "b", 2));
        this.arrList.add(new MixedAll());

        this.linkList = new LinkedList<>();
        this.linkList.add(new MixedAll("a", Color.RED, 1, Language.EN, "b", 2));
        this.linkList.add(new MixedAll());
    }

    public CollectionNotInterface(ArrayList<MixedAll> arrList, LinkedList<MixedAll> linkList) {
        this.arrList = arrList;
        this.linkList = linkList;
    }

    public ArrayList<MixedAll> getArrList() {
        return arrList;
    }

    public void setArrList(ArrayList<MixedAll> arrList) {
        this.arrList = arrList;
    }

    public LinkedList<MixedAll> getLinkList() {
        return linkList;
    }

    public void setLinkList(LinkedList<MixedAll> linkList) {
        this.linkList = linkList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionNotInterface that = (CollectionNotInterface) o;
        return Objects.equals(getArrList(), that.getArrList()) && Objects.equals(getLinkList(), that.getLinkList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArrList(), getLinkList());
    }
}
