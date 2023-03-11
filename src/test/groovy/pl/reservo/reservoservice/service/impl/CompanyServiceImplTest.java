package pl.reservo.reservoservice.service.impl;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.reservo.reservoservice.api.CompanySearchResponse;
import pl.reservo.reservoservice.constants.Profession;
import pl.reservo.reservoservice.model.Address;
import pl.reservo.reservoservice.model.Company;
import pl.reservo.reservoservice.repository.CompanyRepository;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {

    @Mock
    CompanyRepository companyRepository;
    @InjectMocks
    CompanyServiceImpl companyService;

    @ParameterizedTest
    @MethodSource("findAllCompaniesByProfessionCases")
    void shouldFindAllCompaniesByProfession(Profession profession, Set<Company> companies, String professionToFind, int expectedResults){
        //given
        when(companyRepository.findAllByProfession(profession)).thenReturn(companies);
        //when
        val result = companyService.findAllByProfession(professionToFind);
        //then
        verify(companyRepository).findAllByProfession(profession);
        assertNotNull(result);
        assertEquals(expectedResults, result.size());
    }

    private static Stream<Arguments> findAllCompaniesByProfessionCases() {
        return Stream.of(
                Arguments.of(Profession.BARBER, Set.of(Company.builder()
                        .id(UUID.randomUUID())
                        .name("company name")
                        .profession(Profession.BARBER)
                        .address(Address.builder()
                                .city("Warszawa")
                                .houseNumber("123")
                                .street("street")
                                .postCode("12-123")
                                .build())
                        .build(),
                        Company.builder()
                                .id(UUID.randomUUID())
                                .name("company name")
                                .profession(Profession.BARBER)
                                .address(Address.builder()
                                        .city("Gdynia")
                                        .houseNumber("123")
                                        .street("street")
                                        .postCode("12-123")
                                        .build())
                                .build()),
                        "barber",
                        2),
                Arguments.of(Profession.BARBER, Set.of(Company.builder()
                                        .id(UUID.randomUUID())
                                        .name("company name")
                                        .profession(Profession.BARBER)
                                        .address(Address.builder()
                                                .city("Warszawa")
                                                .houseNumber("123")
                                                .street("street")
                                                .postCode("12-123")
                                                .build())
                                        .build(),
                                Company.builder()
                                        .id(UUID.randomUUID())
                                        .name("company name")
                                        .profession(Profession.BARBER)
                                        .address(Address.builder()
                                                .city("Gdynia")
                                                .houseNumber("123")
                                                .street("street")
                                                .postCode("12-123")
                                                .build())
                                        .build()),
                        "not_exists",
                        0)

        );
    }

}