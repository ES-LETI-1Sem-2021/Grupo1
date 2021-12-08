package pt.iscte_iul.ProjetoES_;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHTag;
import org.kohsuke.github.GitHub;

/**
 * Class containing the methods that interact with GitHub.
 */ 

public class GithubMethods {

	private String githubKey;
	private GitHub github;
	private GHRepository repo;

	/**
	 * Builds the necessary GitHub variables.
	 * @throws java.io.IOException Throws IOException
	 */

	public GithubMethods() throws IOException {
		githubKey = "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";
		github = GitHub.connectUsingOAuth(githubKey);
		repo = github.getRepository("PedroArsenio33/ES-LETI-1Sem-2021-Grupo1");
	}

	/**
	 * Gets README.md from GitHub repository.
	 * @return README.md file content
	 * @throws java.io.IOException Throws IOException
	 */

	public String getReadme() throws IOException {
		return IOUtils.toString(repo.getFileContent("README.md").read(), StandardCharsets.UTF_8);
	}

	/**
	 * Gets tags associated with GitHub repository.
	 * @return List of tags
	 * @throws java.io.IOException Throws IOException
	 */

	public List<String> getTags() throws IOException {
		List<String> allTags = new ArrayList<String>(); 
		List<GHTag> tags = repo.listTags().toList();
		for (GHTag tag : tags) {
			String tagName = tag.getName();
			String tagDate = tag.getCommit().getCommitDate().toString();
			allTags.add("Nome: " + tagName.concat("  Data: " + tagDate));
		}
		return allTags;
	}

}
