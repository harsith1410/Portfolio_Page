package com.portfolio.leetcode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
public class LeetCodeService {

    private static final String API_URL_TEMPLATE = "https://leetcode-stats-api.herokuapp.com/%s";

    public Optional<LeetCodeStatsDto> getUserStats(String username) {
        String apiUrl = String.format(API_URL_TEMPLATE, username);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<LeetCodeApiResponse> response = restTemplate.getForEntity(apiUrl, LeetCodeApiResponse.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                LeetCodeApiResponse apiResponse = response.getBody();

                if ("success".equalsIgnoreCase(apiResponse.status)) {
                    LeetCodeStatsDto stats = new LeetCodeStatsDto();
                    stats.setUsername(username);
                    stats.setTotalSolved(apiResponse.totalSolved);
                    stats.setEasySolved(apiResponse.easySolved);
                    stats.setMediumSolved(apiResponse.mediumSolved);
                    stats.setHardSolved(apiResponse.hardSolved);
                    stats.setRanking(apiResponse.ranking);
                    stats.setTotalEasy(apiResponse.totalEasy);
                    stats.setTotalMedium(apiResponse.totalMedium);
                    stats.setTotalHard(apiResponse.totalHard);
                    return Optional.of(stats);
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching LeetCode stats from third-party API: " + e.getMessage());
        }

        return Optional.empty();
    }
}