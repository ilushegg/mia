<form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Log Out" />
    </form>