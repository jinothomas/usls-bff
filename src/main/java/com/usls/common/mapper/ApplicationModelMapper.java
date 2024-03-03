package com.usls.common.mapper;

public interface ApplicationModelMapper<Request, Response, Entity> {
	
	Entity mapRequestToEntity(Request request);
	
	Response mapEntityToResponse(Entity entity);
	
	Entity updateEntityWithRequest(Request request, Entity entity);

}
