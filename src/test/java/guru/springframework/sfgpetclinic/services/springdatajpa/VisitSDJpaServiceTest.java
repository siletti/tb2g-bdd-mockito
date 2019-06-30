package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        //given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        given(visitRepository.findAll()).willReturn(visits);
//        when(visitRepository.findAll()).thenReturn(visits);

        //when
        Set<Visit> foundVisits = service.findAll();

        //then
//        verify(visitRepository).findAll();
        then(visitRepository).should().findAll();
        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void findById() {
        //given
        Visit visit = new Visit();

//        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));

        //when
        Visit foundVisit = service.findById(1L);

        //then
//        verify(visitRepository).findById(anyLong());
        then(visitRepository).should().findById(anyLong());

        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
        //givern
        Visit visit = new Visit();

//        when(visitRepository.save(any(Visit.class))).thenReturn(visit);
        given(visitRepository.save(any(Visit.class))).willReturn(visit);

        //when
        Visit savedVisit = service.save(new Visit());

        //then
//        verify(visitRepository).save(any(Visit.class));
        then(visitRepository).should().save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }

    @Test
    void delete() {
        //given
        Visit visit = new Visit();
        //when
        service.delete(visit);
        //then
//        verify(visitRepository).delete(any(Visit.class));
        then(visitRepository).should().delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        //when
        service.deleteById(1L);
        //then
//        verify(visitRepository).deleteById(anyLong());
        then(visitRepository).should().deleteById(anyLong());
    }
}