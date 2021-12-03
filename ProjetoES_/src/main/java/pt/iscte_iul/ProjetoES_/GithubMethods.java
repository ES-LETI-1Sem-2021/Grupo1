package pt.iscte_iul.ProjetoES_;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.kohsuke.github.*;

public class GithubMethods {
	
	private String githubKey;
	private GitHub github;
	private GHRepository repo;
	
	public GithubMethods() throws IOException {
		githubKey = "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";
		github = GitHub.connectUsingOAuth(githubKey);
		repo = github.getRepository("PedroArsenio33/ES-LETI-1Sem-2021-Grupo1");
	}
	
	public String getReadme() throws IOException {
		return IOUtils.toString(repo.getFileContent("README.md").read(), StandardCharsets.UTF_8);
	}
	
}
