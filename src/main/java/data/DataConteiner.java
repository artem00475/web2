package data;

import java.util.ArrayList;
import java.util.List;

public class DataConteiner {
    private List<Data> dates;

    public DataConteiner() {
        dates = new ArrayList<>();
    }

    public boolean addData(Data data) {
        return dates.add(data);
    }

    public Data getData(int i) {
        return dates.get(i);
    }

    public int getSize() {
        return dates.size();
    }
}
