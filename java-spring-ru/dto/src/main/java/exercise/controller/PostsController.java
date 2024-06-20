package exercise.controller;

import exercise.dto.CommentDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.PostDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(toCommentsDTO(commentRepository.findByPostId(post.getId())));
        return dto;
    }

    private List<CommentDTO> toCommentsDTO(List<Comment> comments) {
        return comments.stream()
                .map(comment -> {
                    var dto = new CommentDTO();
                    dto.setId(comment.getId());
                    dto.setBody(comment.getBody());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping(path = "")
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::toPostDTO)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toPostDTO(post);
    }
}
// END
