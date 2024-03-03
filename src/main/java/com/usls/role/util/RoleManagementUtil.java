package com.usls.role.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.usls.common.dto.FeatureDTO;
import com.usls.role.enums.RolePermissions;
import com.usls.role.enums.RolePermissions.Permission.Feature;

@Component
public class RoleManagementUtil {
	

	private static List<Feature> features = Arrays.asList(Feature.values());
	
	
	public Set<FeatureDTO> getAllFeatures() {
		Set<FeatureDTO> featureSet = new HashSet<>();
		features.forEach((feature)->{
			featureSet.add(new FeatureDTO(feature.name(), feature.getDescription(),RolePermissions.getPermissionDTOByFeature(feature) ));
		});
		
		return featureSet;
	}
}
