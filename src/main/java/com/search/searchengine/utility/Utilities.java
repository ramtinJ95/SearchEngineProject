package com.search.searchengine.utility;

import com.search.searchengine.model.FrontendQuery;

import java.util.ArrayList;

public class Utilities {

    public String formatString(String text){
        StringBuilder json = new StringBuilder();
        String indentString = "";
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            switch (letter) {
                case '{':
                case '[':
                    json.append("\n" + indentString + letter + "\n");
                    indentString = indentString + "\t";
                    json.append(indentString);
                    break;
                case '}':
                case ']':
                    indentString = indentString.replaceFirst("\t", "");
                    json.append("\n" + indentString + letter);
                    break;
                case ',':
                    json.append(letter + "\n" + indentString);
                    break;
                default:
                    json.append(letter);
                    break;
            }
        }
        return json.toString();
    }

    public ArrayList<String> getCategory(FrontendQuery query) {
        ArrayList<String> result = new ArrayList<>();
        if (!query.getAutoAndBoatAndAir().isEmpty()) {
            result.add(query.getAutoAndBoatAndAir());
        }
        if (!query.getBusinessAndProfessional().isEmpty()) {
            result.add(query.getBusinessAndProfessional());
        }
        if (!query.getCharityAndCauses().isEmpty()) {
            result.add(query.getCharityAndCauses());
        }
        if (!query.getCommunityAndCulture().isEmpty()) {
            result.add(query.getCommunityAndCulture());
        }
        if (!query.getFamilyAndEducation().isEmpty()) {
            result.add(query.getFamilyAndEducation());
        }
        if (!query.getFashionAndBeauty().isEmpty()) {
            result.add(query.getFashionAndBeauty());
        }
        if (!query.getFilmAndMediaAndEntertainment().isEmpty()) {
            result.add(query.getFilmAndMediaAndEntertainment());
        }
        if (!query.getFoodAndDrink().isEmpty()) {
            result.add(query.getFoodAndDrink());
        }
        if (!query.getGovernmentAndPolitics().isEmpty()) {
            result.add(query.getGovernmentAndPolitics());
        }
        if (!query.getHealthAndWellness().isEmpty()) {
            result.add(query.getHealthAndWellness());
        }
        if (!query.getHobbiesAndSpecialAndInterest().isEmpty()) {
            result.add(query.getHobbiesAndSpecialAndInterest());
        }
        if (!query.getHomeAndLifestyle().isEmpty()) {
            result.add(query.getHomeAndLifestyle());
        }
        if (!query.getMusic().isEmpty()) {
            result.add(query.getMusic());
        }
        if (!query.getOther().isEmpty()) {
            result.add(query.getOther());
        }
        if (!query.getPerformingAndVisualArts().isEmpty()) {
            result.add(query.getPerformingAndVisualArts());
        }
        if (!query.getReligionAndSpirituality().isEmpty()) {
            result.add(query.getReligionAndSpirituality());
        }
        if (!query.getSchoolActivities().isEmpty()) {
            result.add(query.getSchoolActivities());
        }
        if (!query.getScienceAndTechnology().isEmpty()) {
            result.add(query.getScienceAndTechnology());
        }
        if (!query.getSeasonalAndHoliday().isEmpty()) {
            result.add(query.getSeasonalAndHoliday());
        }
        if (!query.getSportsAndFitness().isEmpty()) {
            result.add(query.getSportsAndFitness());
        }
        if (!query.getTravelAndOutdoor().isEmpty()) {
            result.add(query.getTravelAndOutdoor());
        }
        return result;
    }
}
