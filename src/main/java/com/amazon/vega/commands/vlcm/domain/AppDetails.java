package com.amazon.vega.commands.vlcm.domain;

import com.amazon.vega.commands.vlcm.domain.enums.State;
import com.amazon.vega.commands.vlcm.domain.enums.Type;

public record AppDetails(String application,
                         Type type,
                         Integer pid,
                         Integer id,
                         State state,
                         String lifespan,
                         String timeoutContainer,
                         String launchArgs) {
}
