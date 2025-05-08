/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.application_context.xml;

import java.text.MessageFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodingNomad {
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;
    private final BearNotes bearNotes;

    public String createAwesomeSoftware() {
        return MessageFormat.format(
                "This coding nomad is creating awesome software using, "
                        + "IDE:({0}:{1}), JDK:({2}:{3}), Framework:({4}:{5}), BearNotes:({6}:{7})",
                ide.getName(),
                ide.getVersion(),
                jdk.getName(),
                jdk.getVersion(),
                framework.getName(),
                framework.getVersion(),
                bearNotes.getMarkdown(),
                bearNotes.getWrite());
    }
}
