/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package alkolexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import alkolexa.handlers.CancelandStopIntentHandler;
import alkolexa.handlers.FallbackIntentHandler;
import alkolexa.handlers.HelpIntentHandler;
import alkolexa.handlers.InstructionsIntentHandler;
import alkolexa.handlers.LaunchRequestHandler;
import alkolexa.handlers.RandomCocktailIntentHandler;
import alkolexa.handlers.SessionEndedRequestHandler;
import alkolexa.handlers.SearchCocktailIntentHandler;
import alkolexa.handlers.SearchCocktailCategoryIntentHandler;;


public class AlkolexaStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler(),
                        new RandomCocktailIntentHandler(),
                        new SearchCocktailCategoryIntentHandler(),
                        new InstructionsIntentHandler(),
                        new SearchCocktailIntentHandler()
                        )
                .withSkillId("amzn1.ask.skill.65f49a2f-9e3f-47a7-84c2-228f138002be")
                .build();
    }

    public AlkolexaStreamHandler() {
        super(getSkill());
    }

}
