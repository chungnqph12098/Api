package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import DATN.Class.ReportQuestion;
import DATN.Class.ReportReply;
import DATN.Class.Reports;

public interface ReportReplyDAO extends JpaRepository<ReportReply, Integer>{
}
