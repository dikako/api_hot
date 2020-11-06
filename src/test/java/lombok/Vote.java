package lombok;

@Data
@Builder
public class Vote {
	
	int competition_id;
	int contestant_id;
	int vote_number;
	int video_id;
}
