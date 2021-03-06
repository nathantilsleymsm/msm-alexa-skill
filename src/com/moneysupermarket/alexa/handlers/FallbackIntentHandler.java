package com.moneysupermarket.alexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

// 2018-July-09: AMAZON.FallackIntent is only currently available in en-US locale.
//              This handler will not be triggered except in that locale, so it can be
//              safely deployed for any locale.
public class FallbackIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(final HandlerInput input) {
        return input.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(final HandlerInput input) {
        final String speechText = "Sorry, I don't know that. You can say try saying help!";
        return input.getResponseBuilder()
            .withSpeech(speechText)
            .withSimpleCard("HelloWorld", speechText)
            .withReprompt(speechText)
            .build();
    }

}
