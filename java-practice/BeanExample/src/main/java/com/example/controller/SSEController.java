package com.example.controller;


import java.time.Duration;
import java.time.LocalTime;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class SSEController {
	@GetMapping(path="sse-stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent<String>> streamFlux(){
		return Flux.interval(Duration.ofSeconds(1))
				.map(sequence -> ServerSentEvent.<String> builder()
					.id(String.valueOf(sequence))
					.event("periodic-events")
					.data("Flux " + LocalTime.now().toString())
					.build());
	}
}
