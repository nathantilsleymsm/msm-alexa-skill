/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.moneysupermarket.alexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.moneysupermarket.alexa.handlers.CancelandStopIntentHandler;
import com.moneysupermarket.alexa.handlers.CarMotIntentHandler;
import com.moneysupermarket.alexa.handlers.FallbackIntentHandler;
import com.moneysupermarket.alexa.handlers.HelpIntentHandler;
import com.moneysupermarket.alexa.handlers.LaunchRequestHandler;
import com.moneysupermarket.alexa.handlers.MyCarMotIntentHandler;
import com.moneysupermarket.alexa.handlers.SessionEndedRequestHandler;

public class MSMStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
            .addRequestHandlers(
                new CancelandStopIntentHandler(),
                new HelpIntentHandler(),
                new LaunchRequestHandler(),
                new SessionEndedRequestHandler(),
                new FallbackIntentHandler(),
                new MyCarMotIntentHandler(),
                new CarMotIntentHandler())
            // Add your skill id below
            //.withSkillId("")
            .build();
    }

    public MSMStreamHandler() {
        super(getSkill());
    }

}
