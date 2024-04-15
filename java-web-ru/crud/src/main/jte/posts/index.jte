@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <h1>Posts</h1>
    @for(var post : page.getPosts())
        <ul>
            <li><a href="/posts/${post.getId()}">${post.getName()}</a></li>
            <p>${post.getBody()}</p>
        </ul>
    @endfor
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            @if (page.getCurrentPage() == 0)
                <li class="page-item"><a class="page-link" href="/posts?page=1">Previous</a></li>
            @endif
            @if (page.getCurrentPage() > 1)
                <li class="page-item"><a class="page-link" href="/posts?page=${page.getCurrentPage() - 1}">Previous</a></li>
            @endif
            <li class="page-item"><a class="page-link" href="/posts?page=${page.getCurrentPage()}">${page.getCurrentPage()}</a></li>
            @if(page.getCurrentPage() != page.getPosts().size())
                <li class="page-item"><a class="page-link" href="/posts?page=${page.getCurrentPage() + 1}">Next</a></li>
            @endif
        </ul>
    </nav>
`)
