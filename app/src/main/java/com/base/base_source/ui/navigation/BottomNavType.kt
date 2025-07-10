import com.base.base_source.R

sealed class BottomNavType(
    val iconActive: Int,
    val iconInactive: Int,
    val contentDescription: String
) {
    object Home : BottomNavType(R.drawable.ic_nav_home_active, R.drawable.ic_nav_home_unactive, "Home")
    object Search : BottomNavType(R.drawable.ic_nav_discovery_active, R.drawable.ic_nav_search_unactive, "Search")
    object Add : BottomNavType(R.drawable.ic_nav_add, R.drawable.ic_nav_add, "Add")
    object Follow : BottomNavType(R.drawable.ic_nav_follow_active, R.drawable.ic_nav_follow_unactive, "Follow")
    object Profile : BottomNavType(R.drawable.ic_user, R.drawable.ic_user, "Profile")
}

val bottomNavItems = listOf(
    BottomNavType.Home,
    BottomNavType.Search,
    BottomNavType.Add,
    BottomNavType.Follow,
    BottomNavType.Profile
)