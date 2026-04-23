package mate.academy.rickandmorty.service;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.CharacterResponseDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public CharacterResponseDto getRandomCharacter() {
        Long characterId;
        long count = characterRepository.count();
        if (count == 0) {
            throw new IllegalStateException("No characters found");
        }
        Random random = new Random();
        characterId = random.nextLong(count) + 1;
        return characterMapper.toDto(characterRepository.findById(characterId).orElseThrow());
    }

    public List<CharacterResponseDto> findAllByName(String name) {
        return characterRepository.findAllByNameContains(name).stream()
                .map(characterMapper::toDto)
                .toList();
    }
}
