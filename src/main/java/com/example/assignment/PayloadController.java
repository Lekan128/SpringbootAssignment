package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PayloadController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Lekan";
    }

    @Autowired
    private PayloadService payloadService;

    //post new payload
    @RequestMapping(method = RequestMethod.POST, value = "/load")
    public String addPayload(@RequestBody Payload payload){

        return payloadService.addToPayloads(payload);
    }

    //gets all the payloads form the database
    @RequestMapping("/load")
    public List<Payload> getPayloads(){
        return  payloadService.getAllPayloads();
    }

    //getting payloads with shipperId
    @RequestMapping("/load/{shipperId}")
    public Payload getPayloadWithId(@PathVariable String shipperId){
        return payloadService.getPayloadWithShipperId(shipperId);
    };



    //Update payload
    @RequestMapping(method = RequestMethod.PUT, value = "/load/{shipperId}")
    public void updatePayload(@PathVariable String shipperId, @RequestBody Payload payload){
        payloadService.updatePayload(shipperId, payload);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/load/{shipperId}")
    public void deletePayload(@PathVariable String shipperId){
        payloadService.deletePayload(shipperId);

    }

}
