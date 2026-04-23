package mate.academy.rickandmorty.repository;

import java.util.List;
import mate.academy.rickandmorty.dto.CharacterResponseDto;
import mate.academy.rickandmorty.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findAllByNameContains(String name);

    CharacterResponseDto countCharacterById(Long id);
}
