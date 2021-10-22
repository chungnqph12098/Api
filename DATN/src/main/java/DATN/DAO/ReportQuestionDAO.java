package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import DATN.Class.ReportQuestion;
import DATN.Class.Reports;

public interface ReportQuestionDAO extends JpaRepository<ReportQuestion, Integer>{
}
