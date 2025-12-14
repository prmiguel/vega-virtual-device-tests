package com.amazon.vega.commands.vlcm;

import com.amazon.vega.VegaDriver;
import com.amazon.vega.commands.vlcm.domain.AppDetails;
import com.amazon.vega.commands.vlcm.domain.enums.State;
import com.amazon.vega.commands.vlcm.domain.enums.Type;

import java.util.StringTokenizer;

public class ListAppByApp extends Vlcm<AppDetails> {

    public ListAppByApp(VegaDriver driver) {
        super(driver);
    }

    public ListAppByApp withApp(String app) {
        super.command = String.format("list --app-id %s", app);
        return this;
    }

    @Override
    protected AppDetails transformResult(String result) {
        StringTokenizer st = new StringTokenizer(result, "\n");
        String header = st.nextToken();
        String row = st.nextToken();

        String csv = row.replaceAll(" +", ",");
        String[] values = csv.split(",");
        return new AppDetails(
                values[0],
                Type.valueOf(values[1]),
                Integer.parseInt(values[2]),
                Integer.parseInt(values[3]),
                State.valueOf(values[4]),
                values[5],
                values[6],
                values[7]
        );
    }
}
