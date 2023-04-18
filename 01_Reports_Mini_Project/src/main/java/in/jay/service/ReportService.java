package in.jay.service;

import java.util.List;

import in.jay.entity.CitizenPlan;
import in.jay.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel();
	
	public boolean exportPdf();
}
