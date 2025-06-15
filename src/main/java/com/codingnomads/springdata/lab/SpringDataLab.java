/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab;

import com.codingnomads.springdata.lab.models.Area;
import com.codingnomads.springdata.lab.models.Route;
import com.codingnomads.springdata.lab.repositories.AreaRepository;
import java.util.Arrays;
import java.util.List;

import com.codingnomads.springdata.lab.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().isEmpty()) {

            final List<Area> areas = areaRepository.saveAll(Arrays.asList(
                    Area.builder().code("A").build(),
                    Area.builder().code("B").build(),
                    Area.builder().code("C").build(),
                    Area.builder().code("D").build(),
                    Area.builder().code("G").build(),
                    Area.builder().code("H").build(),
                    Area.builder().code("Y").build(),
                    Area.builder().code("Z").build()));
        }
        if (routeRepository.findAll().isEmpty()) {

        final List<Route> routes = routeRepository.saveAll(Arrays.asList(
                Route.builder()
                        .origin(areaRepository.findByCode("A"))
                        .destination(areaRepository.findByCode("B"))
                        .build(),
                Route.builder()
                        .origin(areaRepository.findByCode("C"))
                        .destination(areaRepository.findByCode("D"))
                        .build(),
                Route.builder()
                        .origin(areaRepository.findByCode("Y"))
                        .destination(areaRepository.findByCode("Z"))
                        .build(),
                Route.builder()
                        .origin(areaRepository.findByCode("G"))
                        .destination(areaRepository.findByCode("H"))
                        .build(),
                Route.builder()
                        .origin(areaRepository.findByCode("B"))
                        .destination(areaRepository.findByCode("Y"))
                        .build(),
                Route.builder()
                        .origin(areaRepository.findByCode("C"))
                        .destination(areaRepository.findByCode("H"))
                        .build()));
        }
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println(areaRepository.findByCode("A"));
        System.out.println(areaRepository.findByCode("B"));
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println(routeRepository.findByOrigin_code("E"));
        System.out.println(routeRepository.findByOrigin_code("L"));
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println(routeRepository.findByCode("A-B"));
        System.out.println(routeRepository.findByCode("C-H"));
        System.out.println(routeRepository.findByCode("A-Z"));
        System.out.println(routeRepository.findByCodeContaining("A-Z"));
    }
}
