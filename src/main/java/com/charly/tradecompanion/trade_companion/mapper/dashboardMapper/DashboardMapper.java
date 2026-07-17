package com.charly.tradecompanion.trade_companion.mapper.dashboardMapper;

import com.charly.tradecompanion.trade_companion.dto.dashBoard.CriterionDashboardResponse;
import com.charly.tradecompanion.trade_companion.dto.dashBoard.TableDashboardResponse;
import com.charly.tradecompanion.trade_companion.entity.AnalysisTable;
import com.charly.tradecompanion.trade_companion.entity.Criterion;

public class DashboardMapper {



    public static TableDashboardResponse toTableDashboardResponse(AnalysisTable table) {
        TableDashboardResponse respons = new TableDashboardResponse();

        respons.setId(table.getId());
        respons.setName(table.getName());
        respons.setScore(respons.getScore());


        return respons;
    }

    public static CriterionDashboardResponse toCriterionDashboardResponse(Criterion criterion){
        CriterionDashboardResponse response = new CriterionDashboardResponse();
        response.setCoefficient(criterion.getCoefficient());
        response.setId(criterion.getId());
        response.setName(criterion.getName());
        response.setScore(00.0);

        return response ;
    }

}
