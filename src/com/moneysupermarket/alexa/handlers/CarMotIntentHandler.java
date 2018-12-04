/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.moneysupermarket.alexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static java.lang.String.format;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

public class CarMotIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(final HandlerInput input) {
        return input.matches(intentName("CarMotIntent"));
    }

    @Override
    public Optional<Response> handle(final HandlerInput input) {
        final Map<String, Slot> slots = ((IntentRequest) input.getRequestEnvelope().getRequest()).getIntent().getSlots();
        final String speechText = "Your M.O.T. for %s is due at worlds end";
        final String regNumber = slots.get("reg").getValue();
        return input.getResponseBuilder()
            .withSpeech(format(speechText, regNumber))
            .withSimpleCard("MoneySuperMarket", regNumber)
            .build();
    }

}
