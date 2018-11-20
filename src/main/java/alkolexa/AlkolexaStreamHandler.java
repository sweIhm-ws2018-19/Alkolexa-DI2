package main.java.alkolexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import main.java.alkolexa.handlers.WhatsMyColorIntentHandler;

public class AlkolexaStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new WhatsMyColorIntentHandler()
                        )

                .build();
    }

    public AlkolexaStreamHandler() {
        super(getSkill());
    }

}
