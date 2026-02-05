package com.ajayMovies.ajayMoviesBackend.JWT;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        //extract the header from thr req.
        String authHeader = request.getHeader("Authorization");

        // 1️⃣ Check if token exists in header
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            //if header exists extract the token From the header(remove Bearer and only token)
            String token = authHeader.substring(7);

            try {
                // 2️⃣ Extract email from token
                String email = jwtUtil.extractEmail(token);

                // 3️⃣ Validate token before setting authentication
                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null 
                    && jwtUtil.validateToken(token, email)) {

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            email,
                            null,
                            Collections.emptyList());//roles and Authorities
                     

                    //this tells spring this user is authenticated        
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            } catch (Exception e) {
                // Invalid token → ignore and continue
            }
        }

        // 4️⃣ Continue filter chain
        filterChain.doFilter(request, response);
    }
}

// What is SecurityContextHolder?

// It is Spring Security’s memory

// Stores info about the currently logged-in user

// Exists per request

// UsernamePasswordAuthenticationToken =official authentication object 