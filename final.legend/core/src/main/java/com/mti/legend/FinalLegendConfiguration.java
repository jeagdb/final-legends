package com.mti.legend;

import com.mti.legend.persistence.model.PlayerModel;
import com.mti.legend.persistence.model.StatModel;
import com.mti.legend.persistence.model.VocationModel;
import com.mti.legend.persistence.repository.DungeonRepository;
import com.mti.legend.persistence.repository.PlayerRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {PlayerRepository.class, DungeonRepository.class, PlayerModel.class, StatModel.class, VocationModel.class})
@EnableJpaRepositories(basePackages = {"com.mti.legend.*"})
public class FinalLegendConfiguration {
}
