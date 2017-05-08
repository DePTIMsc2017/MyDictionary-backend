package hu.unideb.inf.security.authentication;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipPathRequestMatcher implements RequestMatcher {
    private OrRequestMatcher matcher;
    private RequestMatcher processingMatcher;

    public SkipPathRequestMatcher(String processingPath, String... pathsToSkip) {
        List<RequestMatcher> m = Arrays.stream(pathsToSkip)
                .map(AntPathRequestMatcher::new)
                .collect(Collectors.toList());

        matcher = new OrRequestMatcher(m);
        processingMatcher = new AntPathRequestMatcher(processingPath);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return !matcher.matches(request) && processingMatcher.matches(request);
    }
}

