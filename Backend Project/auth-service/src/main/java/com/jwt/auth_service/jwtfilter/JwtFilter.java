package com.jwt.auth_service.jwtfilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        // 1. Handle OPTIONS preflight requests: Allow them to pass through immediately.
//        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
//            filterChain.doFilter(request, response);
//            return; // CRUCIAL: Stop further processing for OPTIONS
//        }
//
//        // 2. Extract Authorization header
//        String authHeader = request.getHeader("authorization");
//
//        // 3. Handle missing/invalid Authorization header for non-OPTIONS requests
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set 401 Unauthorized
//            response.getWriter().write("Authorization header missing or invalid.");
//            return; // Stop processing this request
//        }
//
//        // 4. Extract token and validate
//        String token = authHeader.substring(7); // Remove "Bearer " prefix
//
//        try {
//            Claims claims = Jwts.parser().setSigningKey("idontsay").parseClaimsJws(token).getBody();
//
//            // Store user details in request attributes if validation is successful
//            String curUserEmailId = (String) claims.get("userEmailId");
//            String curUserName = (String) claims.get("userName");
//            String curUserRole = (String) claims.get("role");
//
//            System.out.println("\nToken : " + token);
//            System.out.println(curUserName);
//            System.out.println(curUserEmailId);
//            System.out.println(curUserRole);
//
//            request.setAttribute("currentUserEmailId", curUserEmailId);
//            // You can set other attributes as needed
//
//            // 5. Continue filter chain if token is valid
//            filterChain.doFilter(request, response);
//
//        } catch (Exception e) {
//            // Handle all JWT-related validation failures (invalid, expired, malformed token)
//            System.err.println("JWT Validation Failed: " + e.getMessage());
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set 401 Unauthorized
//            response.getWriter().write("Invalid or expired JWT token.");
//            return; // Stop processing this request
//        }
        // when request comes here,
        // check for token in request header (Authorization header)
        // if Authorization header exists and it has valid token : forward the request to controller

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            filterChain.doFilter(httpServletRequest, servletResponse);
            return;
        }

        String authHeader = httpServletRequest.getHeader("authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer")){
            throw new ServletException();
        }
        else { // authorization header is existing, token also existing starting with 'Bearer'
            String token = authHeader.substring(7);
            System.out.println("\nToken : " + token);
            //Jwts.parser().setSigningKey("idontsay").parse(token);
            //Claims claims = Jwts.parser().setSigningKey("idontsay").parseClaimsJws(token).getBody();
            Jwts.parser().setSigningKey("idontsay").parseClaimsJws(token).getBody();
            // above parser gets failed and throws exception
            // if - not valid token / token is tampered / token expired / key mismatch
//            String curUserEmailId= (String)claims.get("userEmailId");
//            String curUserName = (String)claims.get("userName");
//            String curUserRole = (String)claims.get("role");
//            System.out.println(curUserName);
//            System.out.println(curUserEmailId);
//            System.out.println(curUserRole);

//            httpServletRequest.setAttribute("currentUserEmailId",curUserEmailId);
            filterChain.doFilter(httpServletRequest,servletResponse);
            // to forward request to controller
        }
    }
}
