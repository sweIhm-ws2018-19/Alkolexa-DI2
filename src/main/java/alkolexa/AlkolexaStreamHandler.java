package main.java.alkolexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;


import main.java.alkolexa.handlers.CancelandStopIntentHandler;
import main.java.alkolexa.handlers.FallbackIntentHandler;
import main.java.alkolexa.handlers.HelpIntentHandler;
import main.java.alkolexa.handlers.LaunchRequestHandler;
import main.java.alkolexa.handlers.SessionEndedRequestHandler;
import main.java.alkolexa.handlers.WelcomeHandler;

public class AlkolexaStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                		  new LaunchRequestHandler(),
                          new CancelandStopIntentHandler(),
                          new SessionEndedRequestHandler(),
                          new HelpIntentHandler(),
                          new FallbackIntentHandler(),
                          new WelcomeHandler())
                  .withSkillId("amzn1.ask.skill.6d0140e1-4583-4cc6-907b-4666dff6293c")
                  .build();
    }

    public AlkolexaStreamHandler() {
        super(getSkill());
    }

}
