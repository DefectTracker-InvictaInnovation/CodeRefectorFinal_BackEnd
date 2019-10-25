package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.ReleaseDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ReleaseDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.Release;
import com.sgic.internal.defecttracker.defectservice.services.ReleaseService;

@Service
public class ReleaseDtoMapper {
	
	@Autowired
	public ReleaseService releaseService;

	public List<ReleaseDto> getAllReleases() { // List Method for ReleaseMapper
		List<Release> releaseList = releaseService.getAllRelease();
		return ReleaseDtoConverter.releaseToReleaseDto(releaseList);

	}

	public Release saveRelease(ReleaseDto releaseDto) {
		Release release = ReleaseDtoConverter.relaseDtoToRelease(releaseDto);
		return releaseService.createRelease(release);
	}

}
