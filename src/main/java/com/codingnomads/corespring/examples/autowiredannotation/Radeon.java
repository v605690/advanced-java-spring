/* CodingNomads (C)2023 */
package com.codingnomads.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("radeon")
@ToString
public class Radeon implements VideoCard {}
