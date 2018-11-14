/*
  Hello world!
 
 */

package main.java.alkolexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import main.java.alkolexa.handlers.CancelandStopIntentHandler;
import main.java.alkolexa.handlers.FallbackIntentHandler;
import main.java.alkolexa.handlers.HelpIntentHandler;
import main.java.alkolexa.handlers.LaunchRequestHandler;
import main.java.alkolexa.handlers.SessionEndedRequestHandler;

public class AlkolexaStreamHandler extends SkillStreamHandler {

	private static Skill getSkill() {
		return Skills.standard().addRequestHandlers(
				// new <Your>IntantHandler(),
				new LaunchRequestHandler(), //
				new CancelandStopIntentHandler(), //
				new SessionEndedRequestHandler(), //
				new HelpIntentHandler(), //
				new FallbackIntentHandler())
				// Add your skill id below
				// .withSkillId("")
				.build();
	}

	public AlkolexaStreamHandler() {
		super(getSkill());
	}
}
