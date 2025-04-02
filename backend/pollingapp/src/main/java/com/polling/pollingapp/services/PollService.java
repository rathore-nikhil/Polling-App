package com.polling.pollingapp.services;

import com.polling.pollingapp.model.OptionVote;
import com.polling.pollingapp.model.Poll;
import com.polling.pollingapp.repositories.PollRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        //Get Poll from DB
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        //Get All Options
        List<OptionVote> options = poll.getOptions();

        //If index from vote is not valid, throw error
        if(optionIndex < 0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }

        //Get Selected Options
        OptionVote selectedOption = options.get(optionIndex);

        //Increment vote for selected options
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        //Save incremented option into the DB
        pollRepository.save(poll);
    }
}
