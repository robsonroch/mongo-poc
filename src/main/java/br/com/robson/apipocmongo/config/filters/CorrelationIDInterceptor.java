package br.com.robson.apipocmongo.config.filters;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CorrelationIDInterceptor extends HandlerInterceptorAdapter {
	
	private static String CORRELATION_ID_NAME = "correlationId";
	private String correlationId;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
		correlationId = buscarCorrelationIdHeader(request);
		MDC.put(CORRELATION_ID_NAME, correlationId);
		log.info("correlation ID:" + correlationId);
		return true;
	}

	private String buscarCorrelationIdHeader(HttpServletRequest request) {

		correlationId = request.getHeader("correlation-id");
		if(correlationId ==null || correlationId.isEmpty()) {
			return UUID.randomUUID().toString();
		}
		
		return correlationId;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object Handler, Exception ex) throws Exception {
		MDC.remove(CORRELATION_ID_NAME);
	}
}
