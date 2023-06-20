package com.lowes3.osp.service;

import com.lowes3.osp.dao.ResponseRepository;

import com.lowes3.osp.entity.Response;
import com.lowes3.osp.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService{
	@Autowired
    private ResponseRepository responseRepository;

    @Override
    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public Response getResponseById(Integer userId) {
        Optional<Response> response = responseRepository.findById(userId);
        if (response.isPresent()) return response.get();
        else return null;
    }

    @Override
    public Response updateResponse(Response response) {
        if(responseRepository.existsById(response.getResponseId())) return responseRepository.save(response);
        else return null;
    }

    @Override
    public String deleteResponseById(Integer responseId) {
        Optional<Response> response = responseRepository.findById(responseId);
        if (response.isPresent()){
        	responseRepository.deleteById(responseId);
            return "Deleted the response.";
        }
        else return "Could not find response by Id.";
    }
    
    
    @Override
    public List<Response> getResponses() {
        return (List<Response>) responseRepository.findAll();
    }
}
