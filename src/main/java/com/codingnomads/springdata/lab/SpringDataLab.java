/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab;

import com.codingnomads.springdata.lab.models.Area;
import com.codingnomads.springdata.lab.models.Route;
import com.codingnomads.springdata.lab.models.Waypoint;
import com.codingnomads.springdata.lab.repositories.AreaRepository;
import java.util.Arrays;
import java.util.List;

import com.codingnomads.springdata.lab.repositories.RouteRepository;
import com.codingnomads.springdata.lab.repositories.WayPointRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;
    private final WayPointRepo wayPointRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Route> routes = null;
        if (areaRepository.findAll().isEmpty()) {

            final List<Area> areas = areaRepository.saveAllAndFlush(Arrays.asList(
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

         routes = routeRepository.saveAllAndFlush(Arrays.asList(
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

        if (wayPointRepo.findAll().isEmpty()) {
            Waypoint wp1 = new Waypoint().builder().name("Lowes").lat(40.549984).lon(-74.294726).build();
            wp1.addRoutes(routes);
            wayPointRepo.save(wp1);

            Waypoint wp2 = new Waypoint().builder().name("Chick-Fil-A").lat(40.535764).lon(-74.294802).build();
            wp2.addRoutes(routes);
            wayPointRepo.save(wp2);

            Waypoint wp3 = new Waypoint().builder().name("Home Depot").lat(40.539088).lon(-74.295886).build();
            wp3.addRoutes(routes);
            wayPointRepo.save(wp3);

            Waypoint wp4 = new Waypoint().builder().name("Planet Fitness").lat(40.507204).lon(-74.394745).build();
            wp4.addRoutes(routes);
            wayPointRepo.save(wp4);

        }
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println(areaRepository.findByCode("A"));
        System.out.println(areaRepository.findByCode("B"));
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println(routeRepository.findByOrigin_code("E"));
        System.out.println(routeRepository.findByOrigin_code("L"));
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println(routeRepository.findByCode("A-B"));
        System.out.println(routeRepository.findByCode("C-H"));
        System.out.println(routeRepository.findByCode("A-Z"));
        System.out.println(routeRepository.findByCodeContaining("A-Z"));
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println(wayPointRepo.findByLatAndLon(40.507204, -74.394745));
        System.out.println(wayPointRepo.findAll());
        System.out.println(wayPointRepo.findByName("Home Depot"));
    }
}
